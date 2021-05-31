package com.fissport.blog.service;

import com.fissport.blog.models.Post;
import com.fissport.blog.repos.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ProductService {


    @Autowired
    private PostRepository postRepository;


    public void saveProductToDB(MultipartFile file,String name,String anons,String full_text, String price)
    {
        Post post=new Post();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            post.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        post.setAnons(anons);
        post.setFull_text(full_text);
        post.setName(name);
        post.setPrice(price);
        postRepository.save(post);

    }
}
