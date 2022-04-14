package com.bts.yomojomo.controller;

import static com.bts.yomojomo.controller.ResultMap.FAIL;
import static com.bts.yomojomo.controller.ResultMap.SUCCESS;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.bts.yomojomo.domain.Group;
import com.bts.yomojomo.service.GroupService;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

@RestController
public class GroupController {
  @Autowired //Controller 객체를 만들 때 Dao인터페이스 구현체를 찾아 자동으로 주입한다.
  GroupService groupService;

  @RequestMapping("/group/add")
  public Object add(Group group, MultipartFile file, HttpSession session) {
    try {
      group.setLogo(saveFile(file));
      groupService.add(group);
      return new ResultMap().setStatus(SUCCESS);

    } catch (Exception e) {
      StringWriter out = new StringWriter();
      e.printStackTrace(new PrintWriter(out));

      return new ResultMap().setStatus(FAIL);
    }
  }

  @RequestMapping("/group/get")
  public Object get(int no) {
    Group group = groupService.get(no);
    if (group == null) {
      return new ResultMap().setStatus(FAIL).setData("해당 번호의 모임이 없습니다.");
    }
    return new ResultMap().setStatus(SUCCESS).setData(group);
  }

  @RequestMapping("/group/list")
  public Object list() {
    return new ResultMap().setStatus(SUCCESS).setData(groupService.list());
  }

  @RequestMapping("/group/selectedSicate")
  public Object siList(Group group, HttpSession session) {
    return new ResultMap().setStatus(SUCCESS).setData(groupService.siList(group));
  }  

  @RequestMapping("/group/selectedGucate")
  public Object guList(Group group, HttpSession session) {
    return new ResultMap().setStatus(SUCCESS).setData(groupService.guList(group));
  }  
  @RequestMapping("/group/selectedPurpcate")
  public Object selectedPurpcate(Group group, HttpSession session) {
    return new ResultMap().setStatus(SUCCESS).setData(groupService.selectedPurpcate(group));
  }  

  @RequestMapping("/group/update")
  public int update(Group group) {
    return groupService.update(group);
  }

  @RequestMapping("/group/delete")
  public Object delete(int no) {
    return groupService.delete(no);
  }



  private String saveFile(MultipartFile file) throws Exception {
    if (file != null && file.getSize() > 0) { 
      // 파일을 저장할 때 사용할 파일명을 준비한다.
      String filename = UUID.randomUUID().toString();

      // 파일명의 확장자를 알아낸다.
      int dotIndex = file.getOriginalFilename().lastIndexOf(".");
      if (dotIndex != -1) {
        filename += file.getOriginalFilename().substring(dotIndex);
      }

      // 파일을 지정된 폴더에 저장한다.
      File photoFile = new File("./upload/book/" + filename); // App 클래스를 실행하는 프로젝트 폴더
      file.transferTo(photoFile.getCanonicalFile()); // 프로젝트 폴더의 전체 경로를 전달한다.

      // 썸네일 이미지 파일 생성
      Thumbnails.of(photoFile)
      .size(50, 50)
      .crop(Positions.CENTER)
      .outputFormat("jpg")
      .toFile(new File("./upload/book/" + "50x50_" + filename));

      return filename;

    } else {
      return null;
    }
  }
}