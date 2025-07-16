package com.self_portofolio.portofolio.Viewer;

import org.springframework.stereotype.Service;

import java.util.List;


public interface viewerService {
    List<Viewer> findALl();
    void createViewer(Viewer viewer);
    Viewer getViewerById(Long id);
}
