package pay2park.model.image;

public class ImageResponse {
    private String imageId;
    private String url;

    public ImageResponse() {
    }

    public ImageResponse(String imageId, String url) {
        this.imageId = imageId;
        this.url = url;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
