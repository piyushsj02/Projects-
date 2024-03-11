package com.psj.springbootrest;

import com.psj.springbootrest.model.JobPost;
import com.psj.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping(path={"jobPosts","jobPosts/"})
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId){
        return service.getJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }

    @PostMapping(path={"jobPost","jobPost/"})
    public String addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return "Added Succesfully";
    }

    @PutMapping({"jobPost","jobPost/"})
//    public JobPost updateJob(@RequestBody JobPost jobPost){
    public String updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
//        return service.getJob(jobPost.getPostId());
        return "Updated successfully !!!";
    }


    @DeleteMapping({"jobPost/{postId}","jobPost/"})
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted successfully !";

    }

    @GetMapping({"load","load/"})
    public String loadData(){
        service.load();
        return "Success ";
    }
}
