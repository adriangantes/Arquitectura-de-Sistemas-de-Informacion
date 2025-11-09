package es.udc.asi.exam_rest.web.exceptions;

public class ResourceException extends Exception {
  public ResourceException(String errorMsg) {
    super(errorMsg);
  }
}
