package pay2park.model.cloudinary;

import java.time.Instant;

public class CloudinaryResponse {
    String publicIp;
    Long version;
    String signature;
    int width;
    int height;
    String format;
    String resourceType;
    Instant createAt;
    int bytes;
    String type;
    String url;
    String secureUrl;
    String eTag;

    public CloudinaryResponse() {
    }

    public CloudinaryResponse(String publicIp, Long version, String signature, int width, int height, String format, String resourceType, Instant createAt, int bytes, String type, String url, String secureUrl, String eTag) {
        this.publicIp = publicIp;
        this.version = version;
        this.signature = signature;
        this.width = width;
        this.height = height;
        this.format = format;
        this.resourceType = resourceType;
        this.createAt = createAt;
        this.bytes = bytes;
        this.type = type;
        this.url = url;
        this.secureUrl = secureUrl;
        this.eTag = eTag;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
        this.publicIp = publicIp;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecureUrl() {
        return secureUrl;
    }

    public void setSecureUrl(String secureUrl) {
        this.secureUrl = secureUrl;
    }

    public String geteTag() {
        return eTag;
    }

    public void seteTag(String eTag) {
        this.eTag = eTag;
    }
}
