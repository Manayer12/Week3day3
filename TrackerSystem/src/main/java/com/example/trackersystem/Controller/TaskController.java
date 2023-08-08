package com.example.trackersystem.Controller;

import com.example.trackersystem.ApiResponse.ApiResponse;
import com.example.trackersystem.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
    ArrayList<Task> tasks=new ArrayList<>();

    @GetMapping("/get")
   public ArrayList<Task> getTask(){

        return tasks;
   }

    @GetMapping("/getbytitle")
    public String getTaskBytitle(@RequestBody Task task){
        for(int i=0;i<tasks.size();i++){
        if(tasks.contains(task)) {
            System.out.println(tasks.get(i));
        }else{
               System.out.println("nothing found");
        }
        }return "";}





   @PostMapping("/add")
   public ApiResponse addTask(@RequestBody Task task){
       tasks.add(task);
       return new ApiResponse("Task is added",200);

   }

    @PutMapping("/update/{index}")
    public ApiResponse updateTask(@PathVariable int index, @RequestBody  Task task){
        tasks.set(index, task);
        return new ApiResponse("Task is updated",200);

    }

    @PutMapping("/updatestat/{index}")
    public ApiResponse updatestatus(@PathVariable int index,Task task){
           if(task.getStatus() != "done"){
               task.setStatus("done");
           }
        return new ApiResponse("status is updated",200);

    }


    @DeleteMapping("/delete/{index}")
    public ApiResponse DeleteTask(@PathVariable int index){
        tasks.remove(index);
        return new ApiResponse("Task is deleted",200);

    }




}
