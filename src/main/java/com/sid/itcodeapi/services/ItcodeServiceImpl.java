package com.sid.itcodeapi.services;

import com.sid.itcodeapi.entity.ItcodeEntity;
import com.sid.itcodeapi.model.ItcodeModel;
import com.sid.itcodeapi.repository.ItcodeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ItcodeServiceImpl implements ItcodeService{

    private ItcodeRepository itcodeRepository;

    public ItcodeServiceImpl(ItcodeRepository itcodeRepository) {
        this.itcodeRepository = itcodeRepository;
    }

    @Override
    public ItcodeModel getCodeById(String id) {
        ItcodeEntity code = itcodeRepository.findById(id).get();
        ItcodeModel Itmodel = new ItcodeModel();
        BeanUtils.copyProperties(code, Itmodel);
        return Itmodel;
    }
}
