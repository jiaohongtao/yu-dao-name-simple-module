package com.seabox.module.report.controller.admin.goview;

import com.seabox.framework.common.pojo.CommonResult;
import com.seabox.framework.common.pojo.PageParam;
import com.seabox.framework.common.pojo.PageResult;
import com.seabox.module.report.controller.admin.goview.vo.project.GoViewProjectCreateReqVO;
import com.seabox.module.report.controller.admin.goview.vo.project.GoViewProjectRespVO;
import com.seabox.module.report.controller.admin.goview.vo.project.GoViewProjectUpdateReqVO;
import com.seabox.module.report.convert.goview.GoViewProjectConvert;
import com.seabox.module.report.dal.dataobject.goview.GoViewProjectDO;
import com.seabox.module.report.service.goview.GoViewProjectService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.seabox.framework.common.pojo.CommonResult.success;
import static com.seabox.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

//@Tag(name = "管理后台 - GoView 项目")
@RestController
@RequestMapping("/report/go-view/project")
@Validated
public class GoViewProjectController {

    @Resource
    private GoViewProjectService goViewProjectService;

    @PostMapping("/create")
//    @Operation(summary = "创建项目")
    @PreAuthorize("@ss.hasPermission('report:go-view-project:create')")
    public CommonResult<Long> createProject(@Valid @RequestBody GoViewProjectCreateReqVO createReqVO) {
        return success(goViewProjectService.createProject(createReqVO));
    }

    @PutMapping("/update")
//    @Operation(summary = "更新项目")
    @PreAuthorize("@ss.hasPermission('report:go-view-project:update')")
    public CommonResult<Boolean> updateProject(@Valid @RequestBody GoViewProjectUpdateReqVO updateReqVO) {
        goViewProjectService.updateProject(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
//    @Operation(summary = "删除 GoView 项目")
//    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('report:go-view-project:delete')")
    public CommonResult<Boolean> deleteProject(@RequestParam("id") Long id) {
        goViewProjectService.deleteProject(id);
        return success(true);
    }

    @GetMapping("/get")
//    @Operation(summary = "获得项目")
//    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('report:go-view-project:query')")
    public CommonResult<GoViewProjectRespVO> getProject(@RequestParam("id") Long id) {
        GoViewProjectDO project = goViewProjectService.getProject(id);
        return success(GoViewProjectConvert.INSTANCE.convert(project));
    }

    @GetMapping("/my-page")
//    @Operation(summary = "获得我的项目分页")
    @PreAuthorize("@ss.hasPermission('report:go-view-project:query')")
    public CommonResult<PageResult<GoViewProjectRespVO>> getMyProjectPage(@Valid PageParam pageVO) {
        PageResult<GoViewProjectDO> pageResult = goViewProjectService.getMyProjectPage(
                pageVO, getLoginUserId());
        return success(GoViewProjectConvert.INSTANCE.convertPage(pageResult));
    }

}
