package tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.KeyValues;

public class Parser {

	private final static String files_directory = "root";
	private final static String image_directory = files_directory +  "/resource/flash3/images/";
	private final static String infor_directory = files_directory + "/scripts/npc/";
	
	private final static String items = infor_directory + "items.txt";
	private final static String items_output = "output/items.txt";
	
	private final static String units = infor_directory + "npc_units.txt";
	private final static String units_output = "output/units.txt";
	
	private final static String heroes = infor_directory + "npc_heroes.txt";
	private final static String heroes_output = "output/heroes.txt";

	private final static String abilitis = infor_directory + "npc_abilities.txt";
	private final static String abilitis_output = "output/abilities.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	File dir = new File("output");
    	dir.mkdir();
		try {
			writeOutTokens(readInTokens(items), items_output);
			writeOutTokens(readInTokens(heroes), heroes_output);
			writeOutTokens(readInTokens(units), units_output);
			writeOutTokens(readInTokens(abilitis), abilitis_output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String readInTokens(String input_file) throws IOException, JSONException {
        FileInputStream in = new FileInputStream(input_file);
        StringBuilder str = new StringBuilder(KeyValues.toJSONObject(in).toString(4));
        return str.toString();
    }
    public static void writeOutTokens(String content, String output_file) throws IOException {
    	FileWriter fw = new FileWriter(output_file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();
    }

}
