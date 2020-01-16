package com.horizon.server.itemService.service;

import com.horizon.server.itemInterface.pojo.Picpro;

public interface PicproService {

    Picpro queryPicproByPid(Long pid);

    Integer insertPicpro(Picpro picpro);

    Integer updatePicpro(Picpro picpro);

    Integer deletePicpro(Long pid);
}
