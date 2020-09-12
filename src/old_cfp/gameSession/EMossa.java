package gameSession;

public enum EMossa {
	CARTA, FORBICE, PIETRA;
	
	public final static EMossa string2mossa(String mossa){
		if(mossa.equals("CARTA")) return CARTA;
		if(mossa.equals("FORBICE")) return FORBICE;
		if(mossa.equals("PIETRA")) return PIETRA;
		return null;
	}
}