package com.example.spring_rest_practicer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_rest_practicer.model.JobPost;
import com.example.spring_rest_practicer.service.JobService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class SpringController {
    
    @Autowired
    JobService serviceprov;

    @GetMapping("JobPost")
    public List<JobPost> name(){
        return serviceprov.getAllJobs();
    }

    @GetMapping("onePost/{postId}")
    public JobPost getOneJob(@PathVariable("postId") int postId){
      return serviceprov.getOneJob(postId);
    }
    //-->> Now lets try to do the Post of the Job

    @PostMapping("JobPost")
    public JobPost namer(@RequestBody JobPost jobpost){
        serviceprov.addJobPost(jobpost);
        return serviceprov.getOneJob(jobpost.getPostId());
    }

    @PutMapping("JobPost/{postId}")
    public JobPost updaterJob(@RequestBody JobPost jobpost,@PathVariable("postId") int postId){
        serviceprov.updateJob(jobpost,postId);
          return serviceprov.getOneJob(jobpost.getPostId());
    }


    @DeleteMapping("JobPost/{postId}")
    public String deleting(@PathVariable("postId") int postId){
        serviceprov.deleteJob(postId);
       return "Deleted";
    }
}
