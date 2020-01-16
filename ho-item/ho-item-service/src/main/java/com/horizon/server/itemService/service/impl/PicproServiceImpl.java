package com.horizon.server.itemService.service.impl;

import com.horizon.server.common.enums.ExceptionEnums;
import com.horizon.server.common.exception.HoException;
import com.horizon.server.itemInterface.pojo.Picpro;
import com.horizon.server.itemService.mapper.PicproMapper;
import com.horizon.server.itemService.service.PicproService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PicproServiceImpl implements PicproService {

    @Autowired
    private PicproMapper picproMapper;


    @Override
    public Picpro queryPicproByPid(Long pid) {

        Picpro picpro1 = new Picpro();
        picpro1.setId(pid);
        Picpro picpro = picproMapper.selectByPrimaryKey(picpro1);
        if (picpro == null){
            throw new HoException(ExceptionEnums.CATEGORY_NOT_FOUND);
        }
        return picpro;
    }

    @Override
    public Integer insertPicpro(Picpro picpro) {

        picpro.setId(null);
        int result = picproMapper.insert(picpro);
        if (result != 1){
            throw new HoException(ExceptionEnums.Store_CREATE_FAILED);
        }

        return result;
    }

    @Override
    public Integer updatePicpro(Picpro picpro) {

        Picpro picproUpdate = new Picpro();
        picproUpdate.setId(picpro.getId());
        picproUpdate.setPoint(picpro.getPoint());
        picproUpdate.setKind(picpro.getKind());
        int result = picproMapper.updateByPrimaryKey(picproUpdate);
        if (result != 1){
            throw new HoException(ExceptionEnums.UPDATE_STORE_FAILED);
        }

        return result;
    }

    @Override
    public Integer deletePicpro(Long pid) {

        Picpro picpro = new Picpro();
        picpro.setId(pid);
        int result = picproMapper.deleteByPrimaryKey(picpro);
        if (result != 1){
            throw new HoException(ExceptionEnums.DELETE_STORE_EXCEPTION);
        }

        return result;
    }
}
