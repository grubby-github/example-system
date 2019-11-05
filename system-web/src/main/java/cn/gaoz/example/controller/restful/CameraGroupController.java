package cn.gaoz.example.controller.restful;

import cn.gaoz.example.CameraGroupService;
import cn.gaoz.example.dao.po.Cameragroup;
import cn.gaoz.example.model.vo.rest.RespMsgVO;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/cameragroup")
@Api(tags = "REST摄像机分组")
public class CameraGroupController extends BaseController {
    @Resource
    private CameraGroupService cameraGroupService;

    /**
     * URL:http://{ip}:{port}/rest/cameragroup
     * method:POST
     *
     * @param cameragroup
     * @return
     */
    @PostMapping
    @ApiOperation(value = "新增一个摄像机分组", notes = "cameragroup表新增一个摄像机分组")
    public ResponseEntity<RespMsgVO> createOne(@RequestBody Cameragroup cameragroup) {
        Integer id = this.cameraGroupService.createOne(cameragroup);
        if (id >= 0) {
            return super.getRespOk(id);
        } else {
            return super.getRespFail();
        }
    }

    /**
     * URL:http://{ip}:{port}/rest/cameragroup
     * method:PUT
     *
     * @param cameragroup
     * @return
     */
    @PutMapping
    @ApiOperation(value = "更新一个摄像机分组", notes = "cameragroup表更新符合主键的一个摄像机分组")
    public ResponseEntity<RespMsgVO> updateOne(@RequestBody Cameragroup cameragroup) {
        if (this.cameraGroupService.updateOne(cameragroup)) {
            return super.getRespOk();
        } else {
            return super.getRespFail();
        }
    }

    /**
     * URL:http://{ip}:{port}/rest/cameragroup/{id}
     * method:DELETE
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除一个摄像机分组", notes = "cameragroup表删除符合主键的一个摄像机分组")
    public ResponseEntity<RespMsgVO> deleteOne(@PathVariable("id") Integer id) {
        if (this.cameraGroupService.deleteOne(id)) {
            return super.getRespOk();
        } else {
            return super.getRespFail();
        }
    }

    /**
     * URL:http://{ip}:{port}/rest/cameragroup?ids={ids}
     * method:DELETE
     *
     * @param ids
     * @return
     */
    @DeleteMapping()
    @ApiOperation(value = "删除多个摄像机分组", notes = "cameragroup表删除符合主键的多个摄像机分组")
    public ResponseEntity<RespMsgVO> deleteBatch(@RequestParam("ids") List<Integer> ids) {
        if (this.cameraGroupService.deleteBatch(ids)) {
            return super.getRespOk();
        } else {
            return super.getRespFail();
        }
    }

    /**
     * URL:http://{ip}:{port}/rest/cameragroup/{id}
     * method:GET
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "查询一个摄像机分组", notes = "cameragroup表返回符合主键的一个摄像机分组")
    public ResponseEntity<RespMsgVO> getOne(@PathVariable("id") Integer id) {
        return super.getRespOk(this.cameraGroupService.getOne(id));
    }

    /**
     * URL:http://{ip}:{port}/rest/cameragroup?args={args}
     * method:GET
     *
     * @return
     */
    @GetMapping()
    @ApiOperation(value = "查询多个摄像机分组", notes = "cameragroup表返回符合条件的多个摄像机分组")
    public ResponseEntity<RespMsgVO> getList(@RequestParam(name = "platformId", required = false) Integer platformId,
                                             @RequestParam(name = "parentGroupId", required = false) Integer parentGroupId,
                                             @RequestParam(name = "name", required = false) String name,
                                             @RequestParam(name = "pageNum", required = false, defaultValue = "${cms.defaultValue.pageNum}") Integer pageNum,
                                             @RequestParam(name = "pageSize", required = false, defaultValue = "${cms.defaultValue.pageSize}") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return super.getRespOkByPage(this.cameraGroupService.getList(platformId, parentGroupId, name));
    }

    /**
     * URL:http://{ip}:{port}/rest/cameragroup/tree
     * method:GET
     *
     * @return
     */
    @GetMapping("/tree")
    @ApiOperation(value = "获取镜头组及镜头", notes = "一次性返回所有的镜头组和镜头")
    public ResponseEntity<RespMsgVO> getTree() {
        return super.getRespOkByPage(this.cameraGroupService.getTree());
    }

    /**
     * URL:http://{ip}:{port}/rest/cameragroup/stepgroup/{id}
     * method:GET
     *
     * @param id
     * @return
     */
    @GetMapping("/stepgroup/{id}")
    @ApiOperation(value = "逐级获取镜头组", notes = "按照条件返回本级相应的子级,查询根组可以传入0")
    public ResponseEntity<RespMsgVO> getStepGroup(@PathVariable("id") Integer id) {
        return super.getRespOkByPage(this.cameraGroupService.getStepGroup(id));
    }

    /**
     * URL:http://{ip}:{port}/rest/cameragroup/stepcamera/{id}
     * method:GET
     *
     * @param id
     * @return
     */
    @GetMapping("/stepcamera/{id}")
    @ApiOperation(value = "逐级获取镜头", notes = "按照条件返回本级相应的镜头,查询没有分组的镜头可以传入0")
    public ResponseEntity<RespMsgVO> getStepCamera(@PathVariable("id") Integer id) {
        return super.getRespOkByPage(this.cameraGroupService.getStepCamera(id));
    }

}
