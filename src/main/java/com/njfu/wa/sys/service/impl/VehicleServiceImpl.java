package com.njfu.wa.sys.service.impl;

import com.njfu.wa.sys.domain.Block;
import com.njfu.wa.sys.domain.Vehicle;
import com.njfu.wa.sys.exception.BusinessException;
import com.njfu.wa.sys.mapper.VehicleMapper;
import com.njfu.wa.sys.service.VehicleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Resource
    private VehicleMapper vehicleMapper;

    /**
     * 获取车辆列表
     *
     * @param vehicle vehicleId vehicleType useStatus
     * @param block   blockId
     * @return data
     */
    @Override
    public List<Vehicle> getVehicles(Vehicle vehicle, Block block) {
        vehicle.setBlock(block);
        return vehicleMapper.selectVehicles(vehicle);
    }

    /**
     * 新增车辆信息
     *
     * @param vehicle vehicleId vehicleType useStatus vehiclePs
     * @param block   blockId
     */
    @Override
    public void addVehicle(Vehicle vehicle, Block block) {
        this.convertNull(vehicle, block);
        int res = vehicleMapper.insertVehicle(vehicle);
        if (res <= 0) {
            throw new BusinessException("新增车辆信息失败，请检查新增编号是否存在！");
        }
    }

    /**
     * 修改车辆信息
     *
     * @param vehicle vehicleId vehicleType useStatus vehiclePs
     * @param block   blockId
     */
    @Override
    public void modifyVehicle(Vehicle vehicle, Block block) {
        this.convertNull(vehicle, block);
        int res = vehicleMapper.updateVehicle(vehicle);
        if (res == 0) {
            throw new BusinessException("修改车辆信息失败");
        }
    }

    /**
     * 删除车辆信息
     *
     * @param vehicle vehicleId
     */
    @Override
    public void removeVehicle(Vehicle vehicle) {
        int res = vehicleMapper.deleteVehicle(vehicle);
        if (res == 0) {
            throw new BusinessException("删除车辆信息失败");
        }
    }

    /**
     * 使得blockId、vehiclePs不为空字符串
     *
     * @param vehicle vehiclePs
     * @param block   blockId
     */
    private void convertNull(Vehicle vehicle, Block block) {
        if (!"".equals(block.getBlockId())) {
            vehicle.setBlock(block);
        } else {
            vehicle.setBlock(new Block());
        }

        if ("".equals(vehicle.getVehiclePs())) {
            vehicle.setVehiclePs(null);
        }
    }
}
