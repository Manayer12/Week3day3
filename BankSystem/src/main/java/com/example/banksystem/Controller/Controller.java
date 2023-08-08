package com.example.banksystem.Controller;
import com.example.banksystem.ApiResponse.ApiResponse;
import com.example.banksystem.Model.Customer;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class Controller {

    ArrayList<Customer> customers=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customer> getCustomer(){
        return customers;
    }


    @PostMapping("/add")
    public ApiResponse addCustomer(@RequestBody Customer customer){
        customers.add(customer);
        return new ApiResponse("customer is added",200);

    }

    @PutMapping("/update/{index}")
    public ApiResponse updateCustomer(@PathVariable int index, @RequestBody  Customer customer){
        customers.set(index, customer);
        return new ApiResponse("customer is updated",200);

    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse DeleteCustomer(@PathVariable int index){
        customers.remove(index);
        return new ApiResponse("customer is deleted",200);

    }

    @PutMapping("/updatedep/{index}")
    public ApiResponse updateDeposit(@PathVariable int index, @RequestBody  Customer customer){
         customer.setBalance(customer.getBalance()+1000);

        customers.set(index,customer);
        return new ApiResponse("customer account has Deposit operation,balance changed ",200);

    }

    @PutMapping("/updatewith/{index}")
    public ApiResponse updatewithdraw(@PathVariable int index, @RequestBody  Customer customer){
        if (customer.getBalance()>1000) {
            customer.setBalance(customer.getBalance() - 1000);

        }
        customers.set(index,customer);
        return new ApiResponse("customer account has Withdraw operation,balance changed",200);

    }}
