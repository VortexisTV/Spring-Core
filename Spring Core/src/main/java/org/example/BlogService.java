package org.example;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements MyService {
    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
    public String createBlog(String title, String content) {
        // Create a new Blog object
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);

        // Save the blog post to the database
        blogRepository.save(blog);
        return "Blog created successfully";
    }

    public String viewBlog(Long blogId) {
        // Fetch the blog post from the database
        Blog blog = blogRepository.findById(blogId).orElse(null);

        // Return the blog post if found, otherwise return an error message
        if (blog != null) {
            return "Viewing blog with ID: " + blogId + "\nTitle: " + blog.getTitle() + "\nContent: " + blog.getContent();
        } else {
            return "Blog with ID " + blogId + " not found";
        }
    }

}

