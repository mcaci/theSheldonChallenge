package app.player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import player.EPlayer;

import gameSession.move.EMossa;

public class FilePlayer extends Player {
	
	private File movesList;

	public FilePlayer(EPlayer p) {
		super(p);
		String pathname = "./CFP.txt"; // to be prompted next time
		movesList = new File(pathname);
	}

	@Override
	public EMossa chooseMove() {
		
		Vector<String> outcomes = new Vector<String>();
		try {
			outcomes = processLineByLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String s = getRandOutcome(outcomes);
		switch(s.charAt(0)){
			case 'C':
				return EMossa.CARTA;
			case 'F':
				return EMossa.FORBICE;
			case 'P':
				return EMossa.PIETRA;
			default:
			try {
				throw new Exception("should never get here, something went wrong with the choice");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null; // should never get here
	}
	
	private String getRandOutcome(Vector<String> outcomes){
		  return outcomes.get((int)(java.lang.Math.random() * numPossibleChoices));
	}
	
	/* *************************************************** */
	/* SUPPORT FUNCTIONS FOR READING FILE - for future use */
	/* *************************************************** */
	
	/** Template method that calls {@link #processLine(String)}.  */
	private final Vector<String> processLineByLine() throws FileNotFoundException {
	    //Note that FileReader is used, not File, since File is not Closeable
	    Scanner scanner = new Scanner(new FileReader(movesList));
	    Vector<String> outcomes = new Vector<String>();
	    try {
	      //first use a Scanner to get each line
	      while ( scanner.hasNextLine() ){
	        outcomes = processLine( scanner.nextLine() );
	      }
	    }
	    finally {
	      //ensure the underlying stream is always closed this only has any effect if the item 
	      //passed to the Scanner constructor implements Closeable (which it does in this case).
	      scanner.close();
	    }
	    return outcomes;
	  }

	  /** 
	   Method for processing lines of a (comma-separated) file. Was void before...
	    
	   This simple default implementation expects simple name-value pairs, separated by commas <br/> 
	   Examples of expected content of the file: <tt>"C,F,P"</tt>
	  */
	  private Vector<String> processLine(String line){
		  //use a second Scanner to parse the content of each line 
		  Scanner scanner = new Scanner(line);
		  scanner.useDelimiter(",");
		  Vector<String> outcomes = new Vector<String>();
		  String choice;
		  while(scanner.hasNext()){
			  choice = scanner.next();
			  outcomes.add(choice);
		  }
		  //no need to call scanner.close(), since the source is a String
		  return outcomes;
	  }
	  
	  /* *************************************************** */
	  /* SUPPORT FUNCTIONS FOR WRITING FILE - for future use */
	  /* *************************************************** */
	  	
	  /*
	  private void write2File(){
	  	BufferedWriter bufWriter;
		bufWriter = new BufferedWriter(new FileWriter(new File("out")));
		bufWriter.append(sStmt.getSubject().getNameSpace() + " - " + tStmt.getSubject().getNameSpace() + "\n");
	    bufWriter.append(sStmt.getSubject().toString() + " - " + tStmt.getSubject().toString() + "\n");
	    bufWriter.append(sStmt.getObject().as(Resource.class).getNameSpace() + " - " + tStmt.getObject().as(Resource.class).getNameSpace() + "\n");
	    bufWriter.append(sStmt.getObject().as(Resource.class).toString() + " - " + tStmt.getObject().as(Resource.class).toString() + "\n");
	    bufWriter.append("\n");
	    bufWriter.close();
	    */
}
