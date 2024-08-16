package com.nt.Binding;

public class CommentBinding {
    
    private String name;
    private String email;
    private String content;

    private String postdetails;

    
    public String getPostdetails() {
        return postdetails;
    }

    
    public void setPostdetails(String postdetails) {
        this.postdetails = postdetails;
    }
   

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
