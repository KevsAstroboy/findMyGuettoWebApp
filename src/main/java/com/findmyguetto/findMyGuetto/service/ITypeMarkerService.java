package com.findmyguetto.findMyGuetto.service;

import com.findmyguetto.findMyGuetto.model.TypeMarker;

import java.util.List;

public interface ITypeMarkerService {
    TypeMarker saveTypeMarker(TypeMarker typeMarker) throws Exception;

    List<TypeMarker> getAllTypeOfMarker();
}
