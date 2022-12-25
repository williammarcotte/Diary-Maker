import axios from 'axios';
import {useEffect, useState} from 'react'
import Items from './Items'

function ItemList(){
    const [entries,setEntries] = useState([]);
    const [error,setErrors] = useState("");
    const [hide,setHide] = useState(false)

    const loadEntriesFromAPI = ()=>{
        axios.get('http://localhost:8080/api/entries')
        .then(function (response){
            if(response.status===200){
                setEntries(response.data)
                console.log("test")
                console.log(entries)
            }
        })
    }

    const addEntry = (entry)=>{
        axios.post('http://localhost:8080/api/entries/',entry)
        .then(function(response){
            if(response.status===200){
                loadEntriesFromAPI();
            }
        })
        .catch(function(error){
            setErrors(error)
        })
    }

    const deleteEntry = (id)=>{
        axios.delete('http://localhost:8080/api/entries/'+id)
        .then(function(response){
            if(response.status===200){
                loadEntriesFromAPI();
            }
        })
    }

    useEffect(()=>{
        loadEntriesFromAPI();
    },[]);

    const hidfunc=(hidden)=>{
        setHide(hide);
    }

    const formSubmitted = (event)=>{
        event.preventDefault();

        const titleValue = event.target.elements.title.value;
        const contentValue = event.target.elements.content.value;
        const item = {title:titleValue,content:contentValue};

        if(titleValue==='' || contentValue===''){
            setErrors("Enter text for input")
        }
        else{
            setErrors("")
            addEntry(item)
        }
    }
    
    return(
        <div>
            <form onSubmit={formSubmitted}>
                <input placeholder='Enter Title' name="title"></input>
                <input placeholder='Enter content' name="content"></input>
                <button type="submit">submit</button>
            </form>
            {error}
            <br/>

            {entries.map((item)=><Items item={item} hidfunc={hidfunc} hidden={hide} deleteItem={deleteEntry}></Items>)}
            
        </div>
    );
}

export default ItemList;