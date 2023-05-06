package com.pariuteam.back.requestBodies;


import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class FilteredFoodRequestBody {

    private HashMap<String,String> filters;
    private List<String> specialFilters;


}
