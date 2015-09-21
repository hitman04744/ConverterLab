package com.example.bohdan.converterlab.asyncTask;

import com.example.bohdan.converterlab.organisationsModel.Organisations;

import java.util.ArrayList;

/**
 * Created by Bohdan on 21.09.2015.
 */
public interface AsyncResponse {
    void processFinish(ArrayList<Organisations> mList);
}
