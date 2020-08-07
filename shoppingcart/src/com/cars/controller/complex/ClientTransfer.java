package com.cars.controller.complex;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebListener;

@WebListener
public class ClientTransfer implements ServletContextListener {

	private static final int CLIENT_THREAD_COUNT = 10;
	private final Executor executor = Executors.newFixedThreadPool(CLIENT_THREAD_COUNT);
	private static final BlockingQueue<Client> Clients = new LinkedBlockingQueue<>();

	static void addClient(Client client) {
		Clients.add(client);
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		int count = 0;
		while (count < CLIENT_THREAD_COUNT) {
			executor.execute(() -> {
				sendDataToClient();

			});
			count++;
		}
	}

	private void sendDataToClient() {
		while (true) {
			Client client;
			client = getClient();

			AsyncContext asyncContext = client.getAsyncContext();
			ServletResponse response = asyncContext.getResponse();
			response.setContentType("tet/plain");
			getDataToSend(client);

			sendDataChunk(client, asyncContext, response);
		}
	}

	private void sendDataChunk(Client client, AsyncContext asyncContext, ServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			out.print("Sending" + client.getByteSend() + "bytes\r\n");
			// check if we have done the work
			if (client.isWorkDone()) {
				// if the 100 bytes are sent, the response is complete
				asyncContext.complete();
			} else {
				// if not, put the client again in the queue
				Clients.put(client);
			}

		} catch (Exception e) {
			asyncContext.complete();
		}
	}

	private void getDataToSend(Client client) {
		client.doWork();
	}

	private Client getClient() {
		Client client;
		try {
			// buscar cliente remoto desde la cola de espera
			// (esta llamada blogs hasta que un cliente esté disponible)
			client = Clients.take();
		} catch (InterruptedException el) {
			throw new RuntimeException("Interrupted ehile waiting for remote times clients");
		}
		return client;

	}
}
