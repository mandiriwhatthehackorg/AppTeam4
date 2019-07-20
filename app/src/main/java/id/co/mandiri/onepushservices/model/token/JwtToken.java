package id.co.mandiri.onepushservices.model.token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JwtToken {
    @SerializedName("jwt")
    @Expose
    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
