package com.app.vn.service.media;

import com.app.vn.common.model.Media;
import com.app.vn.repository.media.MediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MediaServiceImpl implements MediaService {

    private MediaRepository mediaRepository;

    private static final Logger logger = LoggerFactory.getLogger(MediaServiceImpl.class);

    public MediaServiceImpl(MediaRepository mediaRepository){
        this.mediaRepository= mediaRepository;
    }

    @Override
    @Transactional
    public Media add(Media media) {
        return mediaRepository.save(media);
    }
}
