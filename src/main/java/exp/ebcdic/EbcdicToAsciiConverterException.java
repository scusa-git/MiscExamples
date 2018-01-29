package exp.ebcdic;

public class EbcdicToAsciiConverterException extends RuntimeException {

	private static final long serialVersionUID = 4284182504410396115L;

	public EbcdicToAsciiConverterException(String message, Throwable e) {
    super(message, e);
  }

  public EbcdicToAsciiConverterException(String message) {
    super(message);
  }

}
