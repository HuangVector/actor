package cn.vector.concurrent.racecondition;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-20 16:04
 */
public class EnergyTransferTask implements Runnable {
    //共享的能量世界
    private EnergySystem energySystem;
    //能量转移的源能量盒子下标
    private int fromBox;
    //单次能量转移最大单元
    private double maxAmount;
    //最大休眠时间（毫秒）
    private int DELAY = 10;
     volatile boolean keepRunning = true;

    /**
     *
     * @param energySystem
     * @param fromBox
     * @param maxAmount
     */
    public EnergyTransferTask(EnergySystem energySystem, int fromBox, double maxAmount) {
        this.energySystem = energySystem;
        this.fromBox = fromBox;
        this.maxAmount = maxAmount;
    }

    @Override
    public void run() {
        try{
            while (keepRunning){
                int toBox = (int)(energySystem.getBoxAmount() * Math.random());
                double amount = maxAmount * Math.random();
                energySystem.transfer(fromBox, toBox, amount);
                Thread.sleep((int)(DELAY * Math.random()));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
