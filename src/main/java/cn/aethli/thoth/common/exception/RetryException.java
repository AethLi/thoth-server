package cn.aethli.thoth.common.exception;

/**
 * @author Termite
 * @device Hades
 * @date 2019-10-14 17:42
 **/
public class RetryException extends Exception {

  String url;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public RetryException(String url) {
    this.url = url;
  }

  public RetryException(String message, String url) {
    super(message);
    this.url = url;
  }

  public RetryException(String message, Throwable cause, String url) {
    super(message, cause);
    this.url = url;
  }

  public RetryException(Throwable cause, String url) {
    super(cause);
    this.url = url;
  }

  public RetryException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace, String url) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.url = url;
  }
}
