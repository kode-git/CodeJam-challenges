/*
 * Complete the 'flippingMatrix' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
 */


function switchMatrix(matrix, i1, i2, j1, j2){
    let temp = matrix[i1][j1] 
    matrix[i1][j1] = matrix[i2][j2]
    matrix[i2][j2] = temp;
    return matrix;
}

function flippingMatrix(matrix) {
    
    let m = matrix[0].length;
    let n = Math.floor(m/2)
    let output = 0;
    for(let i = 0; i < n; i++){
        for(let j = 0; j < n; j++){
            output += Math.max(
                matrix[i][j],
                matrix[i][m - j - 1],
                matrix[m - i - 1 ][j],
                matrix[m - i - 1][m - j - 1]
            )
        }
    }

    return output;
    
    

}

function test(){
    let m = [ 
        [112, 42, 83, 119], 
        [56, 125, 56, 49],
        [15, 78, 101, 43], 
        [62, 98, 114, 108]
    ]

    let output = flippingMatrix(m)
    console.log(output)
}


test();