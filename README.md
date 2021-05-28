# mobile_project_3A

Develop with Android Studio 4.2.1 Test with android 11 R, SDK 31

This is a simple application, displaying all the cryptocurrencies sorted by rank. You can select one and see is description which include current price, high & low within last 24h and a small description. I used the CoinMarketCap api for this application which requires an API Key.

The first list uses a RecyclerView and follow the MVVM architecture as Google recommend. The detail uses a simple text and image view with a "previous" button who guide us to the list of all cryptocurrencies


## API Reference

#### Get all cryptocurrencies (List)

```http
  GET https://pro-api.coinmarketcap.com/v1/cryptocurrency/map?CMC_PRO_API_KEY=${api_key}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `CMC_PRO_API_KEY` | 794ea8e7-4d80-4942-8171-4ca3b65d445c |

#### Get specific cryptocurrency

```http
  GET https://pro-api.coinmarketcap.com/v1/cryptocurrency/info?CMC_PRO_API_KEY=${api_key}&id=${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `api_key` | `CMC_PRO_API_KEY` | 794ea8e7-4d80-4942-8171-4ca3b65d445c |
| `id`      | `string` | Id of coin to fetch |

###### [documentation here](https://coinmarketcap.com/api/documentation/v1/)

## What does it look like? 
![List](https://github.com/AnthonyRP05/mobile_project_3A/blob/master/Screenshots/Night%20theme/photo_2021-05-28_20-29-29.jpg)
![Detail](https://github.com/AnthonyRP05/mobile_project_3A/blob/master/Screenshots/Night%20theme/photo_2021-05-28_20-29-24.jpg)

###### [More to see here !](https://github.com/AnthonyRP05/mobile_project_3A/tree/master/Screenshots)


## Features

- Light/dark mode take into account
- List all cryptocurrencry
- Display only one coin with a description and the logo 

  
## Tech Stack

**Design pattern / Architecture / Framework:** MVVM, Okhttp3, Retrofit2, SOLID, Singleton, Adapter, Picasso...

**Language:** Kotlin

**Develop:** with Android Studio 4.2.1

**Test:** with android 11 R, SDK 31


## TODO
 - Add cache (I tried two methods, the one seen in TD that doesn't crash my application, and a method using ROOM but this one crashed my app at launch, due to lack of time I didn't have time to study it for a long time and I preferred to make a project without cache, but better coded)
 - Add a conversion option
 - Finger swipe navigation
 - create a Widget
 - Make it watch friendly
 - and more

![Logo](https://studyadv.s3.amazonaws.com/production/counselors/pictures/000/109/322/original/Logo_ESIEA_Baseline_noir.png)

 
## Support

For support, email renaud--parrei@et.esiea.fr or by Teams


##
If you have any advice about my code and what I should do to make it more effective for my TODO list, please let me know. 
If you've enjoyed this project as much as I enjoyed doing it, please put a ⭐

