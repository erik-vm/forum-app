import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import { styled } from '@mui/material/styles';
import Link from "./ThreadLink";
import {TheardData} from "./provdb";

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'left',
    color: theme.palette.text.secondary,
  }));


export default function Thread({props}){
    return(
        
        <Box sx={{ flexGrow: 1}}>
            <p>Welcome to {props}</p>
            <Link props="Post">New Post</Link>
        <Grid container spacing={2} direction="column" justifyContent="flex-end" alignItems="stretch" margin ={10}>
        {TheardData.map(({title, post, image}) =>(
            <Grid>
            <Item>
            <Grid><Item>{title}</Item></Grid>
            <Grid><Item>{post}</Item></Grid>
            <Grid><Item>{image}</Item></Grid>
            </Item>
        </Grid>
        ))};
        </Grid>
        </Box>
    );
}