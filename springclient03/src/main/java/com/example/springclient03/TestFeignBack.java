package com.example.springclient03;


import org.springframework.stereotype.Component;

@Component
public class TestFeignBack implements TestFeign  {
    @Override
    public String test() {
        return "dfg dsfg sdfg dsfg dsfg dsfg dfg ";
    }
}
