package Section13;
/**
 *  풀이 시간 : 시간 초과
 *  시간복잡도 : O(N ^ 4)
 *  풀이 과정 : 2차 배열 - 테트리스
 *    [main strategy]
 *     - background 설정
 *       : key의 한 자리만 비교할수도 있도록 설정
 *         실질적으로 쓰는 부위는 lock.length + (key.length-1)*2 이지만 계산 편리 위해 n * 3
 *     - 90 도 회전 4번 가능 방향으로 체크
 *       : 90도 시계 방향 : rotatekey[(lock.length - 1) - j][i]
 *     - 상하좌우로 이동 체크
 *     - checkLock 통해 background의 lock 위치한 부분 확인
 *         : 0 (홈) /  1 (key / lock의 막힌부분) / 2(key + lock 모두 막혀 겹친 부분)
 *     - update : 다음 90 도 방향 확인위해 key로 수정된 background 초기화
 */

public class programmers_자물쇠열쇠_ps {
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int n = lock.length;
        int[][] background = new int[n * 3][n * 3];

        // background 에 lock 채워주기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                background[n + i][n + j] = lock[i][j];
            }
        }

        // 키를 90도 회전 키 4 개
        for(int i = 0; i < 4; i++){
            key = rotate(key);
            // key 의 수평 이동
            for(int j = 0; j < background.length- (key.length)-1; j++){
                // 수직 이동
                for(int k = 0; k < background.length-(key.length)-1; k++) {
                    // 자물쇠 확인
                    for(int x = 0; x < key.length; x++) {
                        for(int y = 0; y < key.length; y++){
                            background[j+x][k+y] += key[x][y];
                        }
                    }

                    // 주어진 key 와 lock이 일치하는 답변인지 확인
                    if(checkLock(background)) {
                        return true;
                    }

                    // 다음 회전을 탐색하기 위해서 초기화
                    for(int x = 0; x < key.length; x++) {
                        for( int y  = 0; y < key.length; y++) {
                            background[j+x][k+y] -= key[x][y];
                        }
                    }

                }
            }
        }

        return false;
    }

    // 시계 방향으로 90도 회전
    public static int[][] rotate (int[][] key){
        int[][] rotateKey = new int[key.length][key[0].length];
        for(int i = 0; i < key.length; i++){
            for(int j = 0; j < key[i].length; j++){
                //시계방향 rotation
                rotateKey[i][j] = key[key.length-1 -j][i];
            }
        }
        return rotateKey;
    }

    /**
     * Lock 이 일치하는지 확인
     * 모두 1 : 키가 맞는다
     * 2 : 키와 락이 겹친다.
     * 0 : 락과 키가 맞지 않는 부분이 존재
     */
    public static boolean checkLock(int[][] background) {
        int search = background.length / 3; //탐색 범위
        //가운데 lock부분만 탐색하면 겹치는지 확인할수있다.
        for(int i = search; i < search * 2; i++){
            for(int j = search; j < search * 2; j++){
                if(background[i][j] != 1) return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
        int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
        System.out.println(solution(key, lock));
    }
}
