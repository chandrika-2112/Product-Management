import axios from 'axios'
import {useRef} from 'react'
import { useNavigate } from 'react-router-dom'

const AddProduct = () => {

    const navigate = useNavigate();

    const pid = useRef(null);
    const name = useRef(null);
    const image = useRef(null);
    const costPrice = useRef(null);
    const quantity = useRef(null);
    const origin = useRef(null);

    const add_product = () => {
        axios.post("http://localhost:9000/save",{
            pid: parseInt(pid.current.value),
            name: name.current.value,
            image: image.current.value,
            costPrice: parseInt(costPrice.current.value),
            quantity: parseInt(quantity.current.value),
            origin: origin.current.value
        })
        // eslint-disable-next-line no-unused-vars
        .then((posRes) => {
            navigate("/viewProducts");
        }, (errRes) => {
            console.log(errRes);
        });
    }

    const view_product = () => {
        navigate("/viewProducts");
    }

    return(
        <div className='container'>
            <h2>Enter Product Details</h2>
            <fieldset>
                <legend>New Product</legend>
                <input type='number' ref={pid} placeholder='Enter pid' required></input><br></br><br></br>
                <input type='text' ref={name} placeholder='Product Name' required></input><br></br><br></br>
                <input type='text' ref={image} placeholder='Image Url' required></input><br></br><br></br>
                <input type='number' ref={costPrice} placeholder='price' required></input><br></br><br></br>
                <input type='number' ref={quantity} placeholder='quantity' required></input><br></br><br></br>
                <input type='text' ref={origin} placeholder='Origin' required></input><br></br><br></br>
                <button type='submit' onClick={add_product}>Add Product</button><br></br>
            </fieldset>

            <button className='button' onClick={view_product}>View Products</button>
        </div>
    )

}

export default AddProduct;