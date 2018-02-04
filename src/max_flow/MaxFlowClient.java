package max_flow;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;

public class MaxFlowClient {
	
	private boolean localEq(FlowNetwork G, int v){
		return false;
	}
	
	private boolean isFeasible(FlowNetwork G){
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		String fileName = args[0];
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(fileName)));
		FlowNetwork fn = new FlowNetwork(reader);
	}

}












