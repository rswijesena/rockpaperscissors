import fetch from 'unfetch';

export const getAllGames = () => {
   return fetch('/rps/v1/games',{
       headers: {
           'Content-Type': 'application/json',
           'Authorization': 'Basic ' + btoa('apiuser:abc123')
       }})
        .then(response => {
            if (response.ok) {
                return response;
            }
            // convert non-2xx HTTP responses into errors:
            const error = new Error(response.statusText);
            error.response = response;
            return Promise.reject(error);
        })
}

export const addNewPlayer = player => {
    let gameObject = {
        "player" : {
            id: "1"
        },
        "playerShape" : player.shape
    }
   return fetch("rps/v1/game/play", {

        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Basic ' + btoa('apiuser:abc123')
        },
        method: 'POST',
        body: JSON.stringify(gameObject)

    }).then(response => {
        if (response.ok) {
            return response;
        }
        // convert non-2xx HTTP responses into errors:
        const error = new Error(response.statusText);
        error.response = response;
        return Promise.reject(error);
    })
}