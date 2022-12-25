import { useState } from "react";

function Items({item,hidfunc,hidden,deleteItem}){
    const [hidde,setHidden] = useState(hidden)
    return(
        <>
        <span onClick={()=>{setHidden(!hidden);hidfunc(hidden)}}>
            Title:{item.title}  
        </span>

        <span className={!hidde? 'hide':''}>
            <button onClick={()=>{
                deleteItem(item.id)
            }}>Delete Entry</button>
        </span>
        <br/>

        <span className={!hidde? 'hide':''}>
            Content:{item.content}
        </span>
        <br/>
        
        </>
        
    )
}

export default Items;