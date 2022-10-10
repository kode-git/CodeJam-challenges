

function sort(lst){
    const alphaNum = (a, b) => a.localeCompare(b, 'en', { numeric: true })
    return lst.sort(alphaNum)
}


function solver(repository, query){
    repository = sort(repository);
    returnValues = []

    for(let i = 0; i < query.length; i++){
        temporalQuery = query.substring(0, i);
        tempValue = [];
        sugg = 0
        for(let j = 0; j < repository.length; j++){
            if(repository[j].startsWith(temporalQuery) && sugg < 3){
                tempValue.push(repository[j])
                sugg++;
            }
        }
        returnValues.push(tempValue)
    }

    return returnValues
}


function run(){
  let output = solver(["mobile", "mouse", "moneypot", "monitor", "mousepad"], 'mouse')
  console.log(output)
}


run()