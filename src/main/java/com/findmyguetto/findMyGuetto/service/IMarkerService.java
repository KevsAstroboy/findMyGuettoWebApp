package com.findmyguetto.findMyGuetto.service;

import com.findmyguetto.findMyGuetto.model.Marker;

import java.util.List;

public interface IMarkerService {
    Marker saveMarker(Marker marker) throws Exception;

    List<Marker> getAllMarkerByType(String typeMarker) throws Exception;



    void updateMarkerStatus(Long idMarker, Long idUser) throws Exception;
}
