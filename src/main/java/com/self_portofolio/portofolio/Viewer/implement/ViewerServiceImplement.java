package com.self_portofolio.portofolio.Viewer.implement;

import com.self_portofolio.portofolio.Viewer.Viewer;
import com.self_portofolio.portofolio.Viewer.ViewerRepository;
import com.self_portofolio.portofolio.Viewer.viewerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewerServiceImplement implements viewerService {

    ViewerRepository viewerRepository;

    public ViewerServiceImplement(ViewerRepository viewerRepository) {
        this.viewerRepository = viewerRepository;
    }

    @Override
    public List<Viewer> findALl() {
        return viewerRepository.findAll();
    }

    @Override
    public void createViewer(Viewer viewer) {
        viewerRepository.save(viewer);
    }

    @Override
    public Viewer getViewerById(Long id) {
        return viewerRepository.findById(id).orElse(null);
    }
}
