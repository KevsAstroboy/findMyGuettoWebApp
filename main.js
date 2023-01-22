

            const map = L.map('issMap').setView([5.316667, -4.033333], 13);


            const attribution =  '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>';
            const tilesUrl = 'https://tile.openstreetmap.org/{z}/{x}/{y}.png';

            const tiles = L.tileLayer(tilesUrl,{attribution});

            tiles.addTo(map);
            
            let headers = new Headers();

            headers.append('Content-Type', 'application/json');
            headers.append('Accept', 'application/json');

            headers.append('Access-Control-Allow-Origin', '*');
            headers.append('Access-Control-Allow-Credentials', 'true');

            headers.append('GET', 'POST', 'OPTIONS');
            axios.defaults.headers['Access-Control-Allow-Origin'] = '*';


            document.addEventListener('DOMContentLoaded',function(){
            async function fetchMarkerType(url){
                let buttons = document.querySelector('.button');
                let data = await axios(url, {
                    headers: {
                        'Access-Control-Allow-Headers': 'Content-Type',
                        //'Access-Control-Max-Age': 86400,
                        'Access-Control-Allow-Origin':"*",
                        headers
                      },
                    method: 'GET',
                    // withCredentials: true,    
                    // crossorigin: true ,    
                    // mode: 'no-cors', 
                    // withCredentials: true, 
                    credentials: 'same-origin',
                  });

                  let response = await data;
                  console.log(response);
                  for (let index = 0; index < response.data.length; index++) {
                    buttons.innerHTML += `<button type="button" class="btn btn-secondary .click" style="margin-left: 05px;">${response.data[index].typeIntitule}</button>`;
                  }
                  
                //   for (let i = 0; i<response.length; i++) {
                //     buttons.innerHTML += `<button type="button" class="btn btn-secondary">${response.data[i].typeIntitule}</button>`;
                //   }
            };
            fetchMarkerType('http://127.0.0.1:8080/api/type-marker/getAll');
            });
         
               document.addEventListener('click',function (){
               document.querySelector('.click');
                async function fetchAllMarkers(){
                    let data = await axios('http://localhost:8080/api/marker/Lieu de Culte', {
                        headers: {
                            'Access-Control-Allow-Headers': 'Content-Type',
                            //'Access-Control-Max-Age': 86400,
                            'Access-Control-Allow-Origin':"*",
                          },
                        method: 'GET',
                        // withCredentials: true,    
                        // crossorigin: true ,    
                        // mode: 'no-cors', 
                        // withCredentials: true, 
                        credentials: 'same-origin',
                      });

                      let response = await data;
                      console.log(response.data)
                      for (let index = 0; index < response.data.length; index++) {
                        let marker = L.marker([response.data[index].latitude,response.data[index].longitude]).addTo(map);

                        const popUp = `<div class="container">
                        <div class="col-12 col-4">
                            <p class = "lead">${response.data[index].description}</p>
                            <button type="button" class="btn btn-secondary button"><a href="http://maps.google.com/maps?daddr=${response.data[index].latitude},${response.data[index].longitude}&amp;ll="></a>Ouvrez Google Map</button>
                        </div>
                    </div>`
                        marker.bindPopup(popUp);
                      }
                };
                fetchAllMarkers();
            },
              );
            
            // async function getCountry(){
            //   let data = await axios('https://cdn.anychart.com/samples/maps-in-dashboard/states-of-united-states-dashboard-with-multi-select/data.json', {
            //     headers: {
            //         'Access-Control-Allow-Headers': 'Content-Type',
            //         //'Access-Control-Max-Age': 86400,
            //         'Access-Control-Allow-Origin':"*",
            //       },
            //     method: 'GET',
            //     // withCredentials: true,    
            //     // crossorigin: true ,    
            //     // mode: 'no-cors', 
            //     // withCredentials: true,
            //     credentials: 'same-origin',
            //   });

            //   let response = await data;
            //   console.log(response);
            // }
            // getCountry();
            
            // .catch((err) => {
            //     console.log(err);
            //     this.isregister=false;
            // })

            // fetch("https://cdn.anychart.com/samples/maps-in-dashboard/states-of-united-states-dashboard-with-multi-select/data.json",{
            // mode: 'no-cors',
            // //credentials: 'include',
            // method: 'GET',
            // headers: headers
            //         })
            // .then(response => {
            //     console.log(response.json())
            // })
            // .catch(error => console.log(error));
        


// var liveprice = {
//     "async":true,
//     "scroosDomain":true,
//     "url":"http://localhost:8080/api/type-marker/getAll",

//     "method":"GET",
//     "header": {}
// }

// $(document).ready(function(){
//     $.ajax({
//         url:'http://localhost:8080/api/type-marker/getAll',
//         type:'GET',
//         success : function(result){
//             console.log(result)
//         },
//         error:function(err){
//             console.log(err);
//         }
//     })

// })

