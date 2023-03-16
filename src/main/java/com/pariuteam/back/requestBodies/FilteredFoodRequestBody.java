package com.pariuteam.back.requestBodies;


import lombok.Data;

import java.util.HashMap;
@Data
public class FilteredFoodRequestBody {

    private HashMap<String,String> filters;


}
