package cn.jastz.aliyun.service;

import cn.jastz.aliyun.ecs.ECSCreateForm;
import com.aliyuncs.ecs.model.v20140526.*;
import com.aliyuncs.exceptions.ClientException;
import org.apache.commons.lang3.StringUtils;

/**
 * 参考：https://help.aliyun.com/document_detail/63440.html?spm=a2c4g.11186623.3.3.4a938b405I7Um3
 *
 * @author zhiwen
 */
public class ECSInstanceService extends BaseService {

    public ECSInstanceService() {
    }

    public ECSInstanceService(String regionId, String accessKeyId, String accessKeySecret) {
        super(regionId, accessKeyId, accessKeySecret);
    }

    /**
     * 创建ECS实例
     *
     * @param ecsCreateForm
     * @return
     */
    public String create(ECSCreateForm ecsCreateForm) {
        CreateInstanceRequest createInstanceRequest = new CreateInstanceRequest();
        ecsCreateForm.updateRequest(createInstanceRequest);
        CreateInstanceResponse createInstanceResponse;
        try {
            createInstanceResponse = getClient().getAcsResponse(createInstanceRequest);
            return createInstanceResponse.getInstanceId();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 实例的状态是已停止(Stopped)
     *
     * @param instanceId    指定的实例 ID。
     * @param initLocalDisk 适用于 实例规格族 D1、I1 或者 I2 等包含本地盘的实例。当 D1、I1 或者 I2 的本地盘出现故障时，可通过此参数指定启动实例时，是否将实例恢复到最初的健康状态。取值范围：
     *                      true：将实例恢复到最初的健康状态，实例原有本地磁盘中的数据将会丢失。
     *                      false：不做任何处理，维持现状。
     */
    public boolean start(String instanceId, Boolean initLocalDisk) {
        boolean result = false;
        StartInstanceRequest startInstanceRequest = new StartInstanceRequest();
        startInstanceRequest.setInstanceId(instanceId);
        if (initLocalDisk != null) {
            startInstanceRequest.setInitLocalDisk(initLocalDisk);
        }
        StartInstanceResponse startInstanceResponse;
        try {
            startInstanceResponse = getClient().getAcsResponse(startInstanceRequest);
            if (StringUtils.isNotEmpty(startInstanceResponse.getRequestId())) {
                result = true;
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 停止运行一台实例（Running）
     *
     * @param instanceId  指定的实例 ID。
     * @param forceStop   停止实例时的是否强制关机策略。取值范围：
     *                    true：强制关机
     *                    false：正常关机流程
     *                    默认值：false
     * @param confirmStop 是否确认关机。仅对 I1 型实例规格族生效，且为 I1 型的实例规格族的必须入参。取值范围：
     *                    true
     *                    false
     *                    默认值：false
     * @param stoppedMode 停止 ECS 实例后，实例依然计费。取值：KeepCharging
     *                    开通 默认VPC内实例停机不收费 功能后，您可以通过设置 StoppedMode=KeepCharging 保持停机收费，ECS 实例停止后会继续计费，并为您保留 ECS 实例规格库存和公网 IP 地址。
     * @return
     */
    public boolean stop(String instanceId, Boolean forceStop, Boolean confirmStop, String stoppedMode) {

        boolean result = false;
        StopInstanceRequest stopInstanceRequest = new StopInstanceRequest();
        stopInstanceRequest.setInstanceId(instanceId);
        stopInstanceRequest.setForceStop(forceStop);
        stopInstanceRequest.setConfirmStop(confirmStop);
        stopInstanceRequest.setStoppedMode(stoppedMode);
        StopInstanceResponse stopInstanceResponse;
        try {
            stopInstanceResponse = getClient().getAcsResponse(stopInstanceRequest);
            if (StringUtils.isNotEmpty(stopInstanceResponse.getRequestId())) {
                result = true;
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 重启实例（Running）
     *
     * @param instanceId 指定实例的 ID。
     * @param forceStop  重启 ECS 实例前是否强制关机策略。取值范围：
     *                   true：重启 ECS 实例前强制关机
     *                   false：重启 ECS 实例前正常关机
     *                   默认值：false
     * @return
     */
    public boolean reboot(String instanceId, Boolean forceStop) {
        boolean result = false;
        RebootInstanceRequest rebootInstanceRequest = new RebootInstanceRequest();
        rebootInstanceRequest.setInstanceId(instanceId);
        rebootInstanceRequest.setForceStop(forceStop);
        RebootInstanceResponse rebootInstanceResponse;
        try {
            rebootInstanceResponse = getClient().getAcsResponse(rebootInstanceRequest);
            if (StringUtils.isNotEmpty(rebootInstanceResponse.getRequestId())) {
                result = true;
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param instanceId            实例 ID。
     * @param terminateSubscription 是否释放已到期的预付费（包年包月）实例。默认值：false。
     * @param force                 是否强制释放 运行中（Running）的实例。默认值：false。
     * @return
     */
    public boolean delete(String instanceId, Boolean terminateSubscription, Boolean force) {
        boolean result = false;
        DeleteInstanceRequest deleteInstanceRequest = new DeleteInstanceRequest();
        deleteInstanceRequest.setInstanceId(instanceId);
        deleteInstanceRequest.setTerminateSubscription(terminateSubscription);
        deleteInstanceRequest.setForce(force);
        DeleteInstanceResponse deleteInstanceResponse = new DeleteInstanceResponse();
        try {
            deleteInstanceResponse = getClient().getAcsResponse(deleteInstanceRequest);
            if (StringUtils.isNotEmpty(deleteInstanceResponse.getRequestId())) {
                result = true;
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return result;
    }
}
