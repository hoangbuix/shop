export const decode = (token: any) => {
    let jwtData = token.split('.')[1]
    let decodedJwtJsonData = window.atob(jwtData)
    // let decodedJwtData = JSON.parse(Object(decodedJwtJsonData))
    //   console.log('jwtData: ' + jwtData)
    //   console.log(typeof (decodedJwtData), 'decodedJwtJsonData: ' + decodedJwtJsonData)
    //   console.log('ROLE: ' + decodedJwtData.role)
    return decodedJwtJsonData;
}