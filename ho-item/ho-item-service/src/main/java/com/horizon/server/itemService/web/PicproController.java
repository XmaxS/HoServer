package com.horizon.server.itemService.web;

import com.horizon.server.itemInterface.pojo.Picpro;
import com.horizon.server.itemService.service.impl.PicproServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("picpro")
public class PicproController {

    @Autowired
    private PicproServiceImpl picproService;

    @GetMapping("/query/pid/{pid}")
    public ResponseEntity<Picpro> queryPicproByPid(@PathVariable Long pid){
        return ResponseEntity.ok(picproService.queryPicproByPid(pid));
    }

    @PostMapping("/insert")
    public ResponseEntity<Integer> insertPicpro(@RequestBody Picpro picpro){
        return ResponseEntity.ok(picproService.insertPicpro(picpro));
    }

    @PostMapping("/update")
    public ResponseEntity<Integer> updatePicpro(@RequestBody Picpro picpro){
        return ResponseEntity.ok(picproService.updatePicpro(picpro));
    }

    @PostMapping("/delete/pid/{pid}")
    public ResponseEntity<Integer> deletePicpro(@PathVariable Long pid){
        return ResponseEntity.ok(picproService.deletePicpro(pid));
    }

}
