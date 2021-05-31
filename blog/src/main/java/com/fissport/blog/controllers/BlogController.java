package com.fissport.blog.controllers;

import com.fissport.blog.models.Client;
import com.fissport.blog.models.Post;
import com.fissport.blog.repos.ClientRepository;
import com.fissport.blog.repos.PostRepository;

import com.fissport.blog.service.ClientService;
import com.fissport.blog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ProductService productService;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;




    @GetMapping ("/blog")
        public String blogMain (Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        model.addAttribute("title","Товары");
        return "blog-main";
    }
    @GetMapping ("/blog/add")
    public String blogAdd (Model model) {
        model.addAttribute("title","Добавление товара");
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam("anons") String anons, @RequestParam("full_text") String full_text, @RequestParam("price") String price, Model model){
        productService.saveProductToDB(file,name,anons,full_text,price);
        return "redirect:/blog/add";
    }


    ///////////////////////////////////////////////////////////////////////
    @GetMapping ("/clients")
    public String blogClients (Model model){
        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients",clients);
        model.addAttribute("title","корзина");
        return "clients-storage-main";
    }
    @GetMapping ("/clients/storage")
    public String clientsStorage (Model model) {
        model.addAttribute("title","корзина");
        return "clients-storage";
    }
    @PostMapping("/clients/storage")
    public String blogClientStorage(@RequestParam("clientName") String clientName,@RequestParam("email") String email,@RequestParam("number") String number, Model model){
        clientService.saveClientToDB(clientName,email,number);
        return "redirect:/clients/storage";
    }

      @GetMapping("/blog/{id}")
    public String findById(@PathVariable(value = "id") long id, Model model) {
        Optional<Post> postId = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        postId.ifPresent(res::add);
          model.addAttribute("postId",res);
        return "blog-sort";
    }
    @GetMapping ("/search")
    public String blogSearch (@RequestParam("name") String name, Model model) {
        List<Post> post =postRepository.findByNameContainingIgnoreCase(name);
        ArrayList<Post> res = new ArrayList<>();
        //post.ifPresent(res::add);
        for(int i=0;i<post.size();i++)
        {
            res.add(post.get(i));
        }
        model.addAttribute("poster",res);
        return "blog-sort-name";
    }


}
