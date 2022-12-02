import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import { styled } from '@mui/material/styles';
import Button from '@mui/material/Button';
import Link from "./ThreadLink";
import {TheardData} from "./provdb";
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import {ThreadNames} from "./ForumPage"
import TextField from '@mui/material/TextField';

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'left',
    color: theme.palette.text.secondary,
  }));

export default function Post(){
    return(
        
        <Box sx={{ flexGrow: 1}}>
            <p>Create a Post</p>
            <Link>New Post</Link>
        <Grid container spacing={2} direction="column" justifyContent="flex-end" margin ={10}>
            <Grid>
            <Item>
            <FormControl>
            <FormLabel id="demo-radio-buttons-group-label">Which Thread</FormLabel>
            <RadioGroup
                row
                aria-labelledby="demo-radio-buttons-group-label"
                name="radio-buttons-group"
            >
                {ThreadNames.map(i =>(
            <FormControlLabel value={i} control={<Radio />} label={i} />
            ))}
            </RadioGroup>
            </FormControl>
            </Item>
            </Grid>
            <Item>
            <Grid>
                <TextField id="outlined-basic" label="Title" variant="outlined" />
            </Grid>
            <Grid>
            <Box
                sx={{
                    width: 800,
                    height: 300,
                    maxWidth: '100%',
                    maxHeight: '100%',
                }}
                >
                <TextField fullWidth label="Post" multiline rows={10} id="fullWidth" />
            </Box>
            </Grid>
            <Grid>
            <RadioGroup
                row
                aria-labelledby="demo-radio-buttons-group-label"
                name="radio-buttons-group"
            >
            
            <FormControlLabel value="question" control={<Radio />} label="Question" />
            <FormControlLabel value="suggestion" control={<Radio />} label="Suggestion" />
            <FormControlLabel value="clarification" control={<Radio />} label="Clarification" />
            </RadioGroup>
            </Grid>
            <Grid>
                <Button type="submit">Submit post</Button>
            </Grid>
            </Item>
        </Grid>
       
        
        </Box>
    );
}