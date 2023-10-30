package chapter11.thread.demon;

public class ex01 {
    public static void main(String[] args) {
        Thread thr1 = new Thread(() -> {});

        //  💡 따로 그룹을 지정해주지 않은 쓰레드
        //  - main 쓰레드그룹에 속함
        ThreadGroup mainThrGroup = thr1.getThreadGroup();
        String mainThrGroupName = mainThrGroup.getName();

        //  💡 쓰레드 그룹 직접 생성하기
        ThreadGroup threadGroup1 = new ThreadGroup("TG_1");
        String thrGroup1Name = threadGroup1.getName();

        //  💡 그룹에 속한 쓰레드를 만드는 생성자
        Thread thr2 = new Thread(threadGroup1, () -> {});
        String thr2Group1Name = threadGroup1.getName();

        // 💡 또 다른 쓰레드 그룹에 속한 쓰레드 그룹을 만드는 생성자
        ThreadGroup thrGroup3 = new ThreadGroup(threadGroup1,"TG_2");
        String thrGroup3Name = thrGroup3.getParent().getName();

    }
}
