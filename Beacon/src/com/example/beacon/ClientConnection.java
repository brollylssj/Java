package com.example.beacon;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class ClientConnection extends Thread {
	
	private BeaconData data;
	public ClientConnection(BeaconData data)
	{
		this.data = data;
	}

	

	public void run()
	{
		super.run();
		
		Socket socket = null;
		
		try {
			
			
			
			
			
			socket = new Socket("192.168.1.102",5030);
			socket.setTcpNoDelay(true);
			
			Gson gson = new Gson();
			JsonReader jsonReader = new JsonReader(new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8")));
			
			JsonWriter jsonWriter = new JsonWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8")));
			
			jsonWriter.beginArray();
			gson.toJson(data,BeaconData.class,jsonWriter);
			
			jsonWriter.endArray();
			jsonWriter.flush();
			
			jsonReader.beginArray();
			jsonReader.endArray();
			
			
			
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally
		{
			if(socket != null)
				try {
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
		}
		
		
	}
	
}
