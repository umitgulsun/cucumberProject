package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OgretmenResponsePojo {

    private OgretmenOlusturPojo ogretmenOlusturPojo;
    private String message;
    private String httpStatus;

    public OgretmenResponsePojo() {
    }

    public OgretmenResponsePojo(OgretmenOlusturPojo ogretmenOlusturPojo, String message, String httpStatus) {
        this.ogretmenOlusturPojo = ogretmenOlusturPojo;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public OgretmenOlusturPojo getOgretmenOlusturPojo() {
        return ogretmenOlusturPojo;
    }

    public void setOgretmenOlusturPojo(OgretmenOlusturPojo ogretmenOlusturPojo) {
        this.ogretmenOlusturPojo = ogretmenOlusturPojo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "OgretmenResponsePojo{" +
                "ogretmenOlusturPojo=" + ogretmenOlusturPojo +
                ", message='" + message + '\'' +
                ", httpStatus='" + httpStatus + '\'' +
                '}';
    }

}
